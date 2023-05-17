package com.baidu.searchbox.wordscommand.util;

import com.baidu.android.util.KVStorageFactory;
import com.baidu.android.util.sp.SharedPrefsWrapper;
/* loaded from: classes4.dex */
public class InvokeParamsSpUtil extends SharedPrefsWrapper {
    public static final String PARAM_FIRST_INVOKE_APP = "is_first";
    public static final String PARAM_INVOKE_SCHEME = "invoke_scheme";
    public static final String SP_FILE_NAME = "com.baidu.searchbox_invoke_params";

    /* loaded from: classes4.dex */
    public static final class Holder {
        public static final InvokeParamsSpUtil INSTANCE = new InvokeParamsSpUtil();
    }

    public InvokeParamsSpUtil() {
        super(KVStorageFactory.getSharedPreferences(SP_FILE_NAME));
    }

    public static InvokeParamsSpUtil getInstance() {
        return Holder.INSTANCE;
    }
}
