package com.baidu.searchbox.wordscommand.util;
/* loaded from: classes4.dex */
public class CommandException extends Exception {
    public static final long serialVersionUID = 1;
    public final int mErrorCode;

    public CommandException(int i, String str) {
        super("errcode: " + i + ", errmsg: " + str);
        this.mErrorCode = i;
    }

    public CommandException(String str) {
        super(str);
        this.mErrorCode = -1;
    }

    public CommandException(String str, Throwable th) {
        super(str, th);
        if (th instanceof CommandException) {
            this.mErrorCode = ((CommandException) th).getErrorCode();
        } else {
            this.mErrorCode = -1;
        }
    }

    public CommandException(Throwable th) {
        super(th);
        if (th instanceof CommandException) {
            this.mErrorCode = ((CommandException) th).getErrorCode();
        } else {
            this.mErrorCode = -1;
        }
    }

    public int getErrorCode() {
        return this.mErrorCode;
    }
}
