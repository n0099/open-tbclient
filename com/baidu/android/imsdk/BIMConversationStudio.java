package com.baidu.android.imsdk;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.chatmessage.ChatSession;
import com.baidu.android.imsdk.conversation.ConversationStudioManImpl;
import com.baidu.android.imsdk.mcast.CastServiceFactory;
import com.baidu.android.imsdk.mcast.IMcastSetListener;
import com.baidu.android.imsdk.mcast.UnLoginCastService;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
/* loaded from: classes.dex */
public class BIMConversationStudio extends BIMConversation {
    public static String TAG = "BIMConversationStudio";
    public String mCastId;
    public IMcastSetListener mCastListener;
    public UnLoginCastService mCastService;
    public int mCastType;
    public String mCastUrl;
    public boolean mIsReliable;

    public BIMConversationStudio(Context context, BIMManager.CATEGORY category, String str, boolean z, ChatSession chatSession, String str2, int i2) {
        super(context, category, str, chatSession, str2, i2);
        this.mCastUrl = null;
        this.mCastId = "";
        this.mIsReliable = false;
        this.mCastService = null;
        this.mCastUrl = str2;
        this.mCastType = i2;
        this.mCastId = str;
        this.mIsReliable = z;
    }

    private void beginOtherCastType(IMcastSetListener iMcastSetListener) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.stopService(0);
            LogUtils.d(TAG, "stop service before start as service is not null.");
        }
        UnLoginCastService createCastService = CastServiceFactory.createCastService(this.mContext);
        this.mCastService = createCastService;
        try {
            iMcastSetListener.onResult(createCastService.startService(this.mCastId, this.mCastUrl, this.mCastType), this.session.getContacter(), -1L);
        } catch (Exception e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void beginWithCompletion(IMcastSetListener iMcastSetListener) {
        this.mCastListener = iMcastSetListener;
        beginWithCompletion(Long.parseLong(this.mCastId), this.mIsReliable, iMcastSetListener);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void endWithCompletion(IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).endWithCompletion(this.session.getContacter(), iMcastSetListener);
        } else {
            UnLoginCastService unLoginCastService = this.mCastService;
            if (unLoginCastService != null) {
                unLoginCastService.stopService(0);
            }
            iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
        }
        try {
            unregisterLiveMsgReceiveListener(Long.valueOf(this.mCastId).longValue());
        } catch (NumberFormatException e2) {
            LogUtils.e(TAG, "Exception ", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void pauseCastMessage() {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.pause();
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void playCastMessage() {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.replay(this.mCastId, this.mCastUrl, this.mCastType);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void seekCastMessage(int i2) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.seek(i2);
        }
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void sendQuizOpts(long j, long j2, int i2, String str, IMcastSetListener iMcastSetListener) {
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).sendQuizOpts(j, j2, i2, str, iMcastSetListener);
            return;
        }
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.stopService(0);
        }
        iMcastSetListener.onResult(0, this.session.getContacter(), -1L);
    }

    @Override // com.baidu.android.imsdk.BIMConversation
    public void setPullInterval(int i2) {
        UnLoginCastService unLoginCastService = this.mCastService;
        if (unLoginCastService != null) {
            unLoginCastService.setPullInterval(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beginWithCompletion(final long j, final boolean z, IMcastSetListener iMcastSetListener) {
        this.mCastListener = iMcastSetListener;
        if (this.mCastType == 2) {
            ConversationStudioManImpl.getInstance(this.mContext).beginWithCompletion(j, z, new IMcastSetListener() { // from class: com.baidu.android.imsdk.BIMConversationStudio.1
                @Override // com.baidu.android.imsdk.mcast.IMcastSetListener
                public void onResult(int i2, long j2, long j3) {
                    if (i2 == 1316) {
                        BIMConversationStudio.this.mCastType = 0;
                        BIMConversationStudio bIMConversationStudio = BIMConversationStudio.this;
                        bIMConversationStudio.beginWithCompletion(j, z, bIMConversationStudio.mCastListener);
                    }
                    if (BIMConversationStudio.this.mCastListener != null) {
                        BIMConversationStudio.this.mCastListener.onResult(i2, j2, j3);
                    }
                }
            });
        } else {
            beginOtherCastType(iMcastSetListener);
        }
    }
}
