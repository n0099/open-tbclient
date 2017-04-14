package com.baidu.tbadk.core.a;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.a.h;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends GetTplStokenCallback {
    final /* synthetic */ h Te;
    private final /* synthetic */ h.a Tf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, h.a aVar) {
        this.Te = hVar;
        this.Tf = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        if (getTplStokenResult == null) {
            if (this.Tf != null) {
                this.Tf.onFailed();
                return;
            }
            return;
        }
        Map<String, String> map = getTplStokenResult.tplStokenMap;
        if (map == null || map.size() <= 0) {
            if (this.Tf != null) {
                this.Tf.onFailed();
                return;
            }
            return;
        }
        String str = map.get(TbConfig.PassConfig.TPL);
        if (StringUtils.isNULL(str)) {
            if (this.Tf != null) {
                this.Tf.onFailed();
            }
        } else if (this.Tf != null) {
            this.Tf.onSuccess(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetTplStokenResult getTplStokenResult) {
        if (this.Tf != null) {
            this.Tf.onFailed();
        }
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }
}
