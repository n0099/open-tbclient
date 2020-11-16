package com.baidu.android.imsdk.chatuser;

import com.baidu.android.imsdk.IMListener;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public interface IGetUsersProfileBatchListener extends IMListener {
    void onGetUsersProfileBatchResult(int i, String str, ArrayList<Long> arrayList, ArrayList<ChatUser> arrayList2);
}
