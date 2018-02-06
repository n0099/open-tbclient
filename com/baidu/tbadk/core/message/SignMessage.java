package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
/* loaded from: classes.dex */
public class SignMessage extends CustomResponsedMessage {
    public int mSignErrorCode;
    public String mSignErrorString;
    public SignData signData;

    public SignMessage(int i, Object obj) {
        super(2001425, obj);
    }

    public SignMessage(int i) {
        super(2001425);
    }

    public SignMessage() {
        super(2001425);
    }
}
