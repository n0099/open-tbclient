package com.baidu.livesdk.sdk.im;

import android.content.Context;
import com.baidu.android.imsdk.BIMManager;
import com.baidu.android.imsdk.account.IConnectListener;
import com.baidu.android.imsdk.account.ILoginListener;
import com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener;
import com.baidu.android.imsdk.chatmessage.messages.ChatMsg;
import com.baidu.livesdk.api.im.ConnectListener;
import com.baidu.livesdk.api.im.FetchMsgByIdListener;
import com.baidu.livesdk.api.im.IMConnectParams;
import com.baidu.livesdk.api.im.IMConversation;
import com.baidu.livesdk.api.im.IMManager;
import com.baidu.livesdk.api.im.LoginListener;
import com.baidu.livesdk.api.im.LogoutListener;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class BDIMManager implements IMManager {
    public Context mContext;

    public BDIMManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public IMConversation build(Context context, String str, String str2, boolean z) {
        return new BDIMConversation(context, BIMManager.getConversation(this.mContext, str, z, BIMManager.CATEGORY.STUDIO, str2, 2));
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void fetchMsgByMsgId(Context context, int i, long j, long j2, long j3, int i2, int i3, final FetchMsgByIdListener fetchMsgByIdListener) {
        BIMManager.fetchMsgByMsgid(context, i, j, j2, j3, i2, i3, new IFetchMsgByIdListener() { // from class: com.baidu.livesdk.sdk.im.BDIMManager.4
            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i4, String str, String str2, int i5, long j4, long j5, long j6, int i6, int i7, long j7, ArrayList<ChatMsg> arrayList) {
                if (fetchMsgByIdListener != null) {
                    ArrayList<Object> arrayList2 = new ArrayList<>();
                    arrayList2.addAll(arrayList);
                    fetchMsgByIdListener.onFetchMsgByIdResult(i4, str, str2, i5, j4, j5, j6, i6, i7, j7, arrayList2);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void fetchMsgRequest(Context context, long j, long j2, int i, long j3, long j4, long j5, int i2, int i3, final FetchMsgByIdListener fetchMsgByIdListener) {
        BIMManager.fetchMsgRequest(context, j, j2, i, j3, j4, j5, i2, i3, new IFetchMsgByIdListener() { // from class: com.baidu.livesdk.sdk.im.BDIMManager.5
            @Override // com.baidu.android.imsdk.chatmessage.IFetchMsgByIdListener
            public void onFetchMsgByIdResult(int i4, String str, String str2, int i5, long j6, long j7, long j8, int i6, int i7, long j9, ArrayList<ChatMsg> arrayList) {
                if (fetchMsgByIdListener != null) {
                    ArrayList<Object> arrayList2 = new ArrayList<>();
                    arrayList2.addAll(arrayList);
                    fetchMsgByIdListener.onFetchMsgByIdResult(i4, str, str2, i5, j6, j7, j8, i6, i7, j9, arrayList2);
                }
            }
        });
    }

    public void init(long j, int i, String str) {
        BIMManager.init(this.mContext, j, i, str);
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void login(String str, String str2, int i, String str3, String str4, final LoginListener loginListener) {
        BIMManager.login(str, str2, i, str3, str4, new ILoginListener() { // from class: com.baidu.livesdk.sdk.im.BDIMManager.1
            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLoginResult(int i2, String str5) {
                LoginListener loginListener2 = loginListener;
                if (loginListener2 != null) {
                    loginListener2.onLoginResult(i2, str5);
                }
            }

            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLogoutResult(int i2, String str5, int i3) {
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void logout(final LogoutListener logoutListener) {
        BIMManager.logout(new ILoginListener() { // from class: com.baidu.livesdk.sdk.im.BDIMManager.2
            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLoginResult(int i, String str) {
            }

            @Override // com.baidu.android.imsdk.account.ILoginListener
            public void onLogoutResult(int i, String str, int i2) {
                LogoutListener logoutListener2 = logoutListener;
                if (logoutListener2 != null) {
                    logoutListener2.onLogoutResult(i, str, i2);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void produceLine(IMConnectParams iMConnectParams) {
        BIMManager.setProductLine(this.mContext, iMConnectParams.getPl(), iMConnectParams.getVersionName());
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void registerConnectListener(final ConnectListener connectListener) {
        BIMManager.registerConnectListener(new IConnectListener() { // from class: com.baidu.livesdk.sdk.im.BDIMManager.3
            @Override // com.baidu.android.imsdk.account.IConnectListener
            public void onResult(int i) {
                ConnectListener connectListener2 = connectListener;
                if (connectListener2 != null) {
                    connectListener2.onResult(i);
                }
            }
        });
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void tryConnection() {
        BIMManager.tryConnection(this.mContext);
    }

    @Override // com.baidu.livesdk.api.im.IMManager
    public void unregisterConnectListener() {
        BIMManager.unregisterConnectListener();
    }
}
