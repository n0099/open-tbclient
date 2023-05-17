package com.baidu.searchbox.wordscommand.listener;

import com.baidu.searchbox.wordscommand.util.CommandException;
/* loaded from: classes4.dex */
public interface ICommandListener {
    void onCancel();

    void onComplete();

    void onDialogShow();

    void onError(CommandException commandException);
}
