package com.baidu.searchbox.wordscommand.listener;

import com.baidu.searchbox.wordscommand.data.CommandToken;
/* loaded from: classes4.dex */
public interface IGetCommonTokenListener {
    void onFail(Exception exc);

    void onSuccess(CommandToken commandToken);
}
