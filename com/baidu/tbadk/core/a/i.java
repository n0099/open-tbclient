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
    final /* synthetic */ h Oy;
    private final /* synthetic */ h.a Oz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, h.a aVar) {
        this.Oy = hVar;
        this.Oz = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onSuccess(GetTplStokenResult getTplStokenResult) {
        if (getTplStokenResult == null) {
            if (this.Oz != null) {
                this.Oz.onFailed();
                return;
            }
            return;
        }
        Map<String, String> map = getTplStokenResult.tplStokenMap;
        if (map == null || map.size() <= 0) {
            if (this.Oz != null) {
                this.Oz.onFailed();
                return;
            }
            return;
        }
        String str = map.get(TbConfig.PassConfig.TPL);
        if (StringUtils.isNULL(str)) {
            if (this.Oz != null) {
                this.Oz.onFailed();
            }
        } else if (this.Oz != null) {
            this.Oz.onSuccess(str);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFailure(GetTplStokenResult getTplStokenResult) {
        if (this.Oz != null) {
            this.Oz.onFailed();
        }
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onStart() {
    }

    @Override // com.baidu.sapi2.callback.SapiCallback
    public void onFinish() {
    }
}
