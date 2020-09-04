package com.baidu.tbadk.core.atomData;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
public class PaymentConfirmActivityConfig extends IntentConfig {
    public static final String BOOK_ID = "book_id";
    public static final String BOOK_TYPE = "book_type";
    public static final String REQUEST_PARAMS = "request_params";

    public PaymentConfirmActivityConfig(Context context, PaymentConfirmRequestData paymentConfirmRequestData, String str, String str2) {
        super(context);
        getIntent().putExtra(REQUEST_PARAMS, paymentConfirmRequestData);
        getIntent().putExtra("refer_page", str);
        getIntent().putExtra("click_zone", str2);
    }

    public void setBookType(int i) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("book_type", i);
        }
    }

    public void setBookId(String str) {
        Intent intent = getIntent();
        if (intent != null) {
            intent.putExtra("book_id", str);
        }
    }
}
