package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.chatmessage.ISendMessageStatusListener;
import com.baidu.android.imsdk.internal.ListenerManager;
import com.baidu.android.imsdk.utils.NoProGuard;
/* loaded from: classes2.dex */
public abstract class RichMediaMsg extends NormalMsg implements Parcelable, NoProGuard {
    public int mProgress;
    public String mRemoteUrl;

    public RichMediaMsg() {
        this.mRemoteUrl = null;
    }

    private void notifySendProcess() {
        ISendMessageStatusListener iSendMessageStatusListener = (ISendMessageStatusListener) ListenerManager.getInstance().getListener(this.mListenerKey);
        if (iSendMessageStatusListener != null) {
            iSendMessageStatusListener.onSendProgress(this.mProgress, this);
        }
    }

    public int getProgress() {
        return this.mProgress;
    }

    public String getRemoteUrl() {
        return this.mRemoteUrl;
    }

    public void setProgress(int i) {
        this.mProgress = i;
        notifySendProcess();
    }

    public void setRemoteUrl(String str) {
        this.mRemoteUrl = str;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mRemoteUrl);
        parcel.writeInt(this.mProgress);
    }

    public RichMediaMsg(Parcel parcel) {
        super(parcel);
        this.mRemoteUrl = null;
        this.mRemoteUrl = parcel.readString();
        this.mProgress = parcel.readInt();
    }
}
