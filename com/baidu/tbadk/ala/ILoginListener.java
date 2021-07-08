package com.baidu.tbadk.ala;

import java.io.Serializable;
/* loaded from: classes3.dex */
public interface ILoginListener extends Serializable {
    void onCancel();

    void onFail();

    void onSuccess();
}
