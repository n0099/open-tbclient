package com.baidu.android.imsdk.chatuser;

import com.baidu.android.imsdk.IMListener;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public interface IGetUserStatusListener extends IMListener {
    void onGetUsersStatusResult(int i2, String str, ArrayList<UserStatus> arrayList);
}
