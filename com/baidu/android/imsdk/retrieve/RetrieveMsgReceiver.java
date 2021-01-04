package com.baidu.android.imsdk.retrieve;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.chatmessage.IMessageReceiveListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.android.imsdk.chatmessage.messages.ConfigMsg;
import com.baidu.android.imsdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class RetrieveMsgReceiver implements IMessageReceiveListener {
    private static final String TAG = "RetrieveMsgReceiver";
    private static volatile RetrieveMsgReceiver mInstance;
    private Context mContext;

    public static RetrieveMsgReceiver getInstance(Context context) {
        if (mInstance == null) {
            synchronized (RetrieveMsgReceiver.class) {
                if (mInstance == null) {
                    mInstance = new RetrieveMsgReceiver(context);
                }
            }
        }
        return mInstance;
    }

    private RetrieveMsgReceiver(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.android.imsdk.chatmessage.IMessageReceiveListener
    public void onReceiveMessage(int i, int i2, ArrayList<ChatMsg> arrayList) {
        if (i == 0 && arrayList != null && arrayList.size() > 0) {
            synchronized (this) {
                Iterator<ChatMsg> it = arrayList.iterator();
                while (it.hasNext()) {
                    ChatMsg next = it.next();
                    LogUtils.d(TAG, "retrieve-->msg type is:" + next.getMsgType());
                    if (next.getMsgType() == 20 && (next instanceof ConfigMsg)) {
                        String dataList = ((ConfigMsg) next).getDataList();
                        LogUtils.d(TAG, "retrieve-->retrieve config msg:" + dataList);
                        if (!TextUtils.isEmpty(dataList)) {
                            try {
                                JSONArray jSONArray = new JSONArray(dataList);
                                if (jSONArray.length() > 0) {
                                    int length = jSONArray.length();
                                    for (int i3 = 0; i3 < length; i3++) {
                                        RetrieveTaskManager.getInstance(this.mContext).dispatch(jSONArray.optJSONObject(i3));
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
