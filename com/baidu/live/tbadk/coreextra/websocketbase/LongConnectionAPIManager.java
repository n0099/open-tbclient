package com.baidu.live.tbadk.coreextra.websocketbase;

import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.client.socket.SocketLog;
import com.baidu.live.adp.framework.listener.SocketMessageListener;
import com.baidu.live.adp.framework.message.SocketResponsedMessage;
import java.util.HashSet;
/* loaded from: classes11.dex */
public class LongConnectionAPIManager extends SocketMessageListener {
    private static final String MODULE_NAME = "lcapimgr";
    private static final long PING_INTERVAL_FLOATING_VALUE = 20000;
    private static LongConnectionAPIManager _instance = new LongConnectionAPIManager();
    private final SparseArray<CommandErrorRecord> availableAPIs;
    private boolean closeLongConnectionAPI;
    private int longConnectionFailedErrno;
    private int maxErrorCount;
    private long retryTimeInMills;
    private final HashSet<Integer> unavailableAPIS;

    public static LongConnectionAPIManager getInstance() {
        return _instance;
    }

    private LongConnectionAPIManager() {
        super(1001);
        this.maxErrorCount = 3;
        this.retryTimeInMills = 300000L;
        this.availableAPIs = new SparseArray<>();
        this.unavailableAPIS = new HashSet<>();
        this.longConnectionFailedErrno = 0;
        MessageManager.getInstance().registerListener(0, this);
    }

    public boolean isAPIAvailableNow(int i) {
        this.longConnectionFailedErrno = 0;
        if (this.closeLongConnectionAPI) {
            this.longConnectionFailedErrno = 3;
            return false;
        } else if (this.unavailableAPIS.contains(Integer.valueOf(i))) {
            this.longConnectionFailedErrno = 6;
            return false;
        } else if (!MessageManager.getInstance().getSocketClient().isValid()) {
            this.longConnectionFailedErrno = 1;
            return false;
        } else if (System.currentTimeMillis() - MessageManager.getInstance().getSocketClient().getLastReceDataTime() > PingManager.getInstance().getForegroundInterval() + PING_INTERVAL_FLOATING_VALUE) {
            SocketLog.debug(MODULE_NAME, i, 0, "isAPIAvailableNow", 0, "deepsleep");
            this.longConnectionFailedErrno = 2;
            return false;
        } else if (TextUtils.isEmpty("ws://im.tieba.baidu.com:8000")) {
            return false;
        } else {
            CommandErrorRecord commandErrorRecord = this.availableAPIs.get(i);
            if (commandErrorRecord != null && commandErrorRecord.startBlockOnErrorCount) {
                if (Math.abs(System.currentTimeMillis() - commandErrorRecord.startBlockTime) > this.retryTimeInMills) {
                    commandErrorRecord.reset();
                } else {
                    this.longConnectionFailedErrno = 4;
                    return false;
                }
            }
            return true;
        }
    }

    public void reset() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.availableAPIs.size()) {
                this.availableAPIs.valueAt(i2).reset();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onAPIFailed(int i) {
        CommandErrorRecord commandErrorRecord = this.availableAPIs.get(i);
        if (commandErrorRecord == null) {
            commandErrorRecord = new CommandErrorRecord();
            this.availableAPIs.append(i, commandErrorRecord);
        }
        if (commandErrorRecord != null) {
            commandErrorRecord.onError(this.maxErrorCount);
        }
        this.longConnectionFailedErrno = 5;
    }

    public void onAPISuccessed(int i) {
        this.availableAPIs.remove(i);
    }

    public boolean isCloseLongConnectionAPI() {
        return this.closeLongConnectionAPI;
    }

    public void setCloseLongConnectionAPI(boolean z) {
        this.closeLongConnectionAPI = z;
    }

    public void setUnAvailableAPIS(int[] iArr) {
        if (iArr != null && iArr.length > 0) {
            this.unavailableAPIS.clear();
            for (int i : iArr) {
                this.unavailableAPIS.add(Integer.valueOf(i));
            }
        }
    }

    public void setMaxErrorCount(int i) {
        this.maxErrorCount = i;
    }

    public void setRetryTimeInMills(long j) {
        this.retryTimeInMills = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
    }

    /* loaded from: classes11.dex */
    private static class CommandErrorRecord {
        public int errorCount;
        public boolean startBlockOnErrorCount;
        public long startBlockTime;

        private CommandErrorRecord() {
        }

        public void reset() {
            this.errorCount = 0;
            if (this.startBlockOnErrorCount) {
                this.startBlockOnErrorCount = false;
                this.startBlockTime = 0L;
            }
        }

        public void onError(int i) {
            this.errorCount++;
            if (!this.startBlockOnErrorCount && this.errorCount >= i) {
                this.startBlockOnErrorCount = true;
                this.startBlockTime = System.currentTimeMillis();
            }
        }
    }

    public int getLongConnectionFailedErrno() {
        return this.longConnectionFailedErrno;
    }
}
