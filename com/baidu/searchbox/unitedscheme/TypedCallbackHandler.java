package com.baidu.searchbox.unitedscheme;
/* loaded from: classes3.dex */
public interface TypedCallbackHandler extends CallbackHandler {
    public static final int INVOKE_TYPE_SWAN_APP = 0;
    public static final int INVOKE_TYPE_SWAN_GAME = 1;

    int getInvokeSourceType();
}
