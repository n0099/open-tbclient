package com.baidu.tbadk.core.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class SignMessage extends CustomResponsedMessage {
    public int mSignErrorCode;
    public String mSignErrorString;
    public SignData signData;

    public SignMessage(int i, Object obj) {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK, obj);
    }

    public SignMessage(int i) {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK);
    }

    public SignMessage() {
        super(CmdConfigCustom.CMD_SIGN_MODEL_TASK);
    }
}
