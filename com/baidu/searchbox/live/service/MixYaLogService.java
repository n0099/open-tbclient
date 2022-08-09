package com.baidu.searchbox.live.service;

import com.baidu.live.arch.api.IService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J/\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/live/service/MixYaLogService;", "Lcom/baidu/live/arch/api/IService;", "Lkotlin/Any;", "", "tag", "msg", "ext", "", "yaLogWithStringFormat", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lib-live-mini-shell_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public interface MixYaLogService extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 1, 16}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void yaLogWithStringFormat$default(MixYaLogService mixYaLogService, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = "";
                }
                mixYaLogService.yaLogWithStringFormat(str, str2, str3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: yaLogWithStringFormat");
        }
    }

    void yaLogWithStringFormat(String str, String str2, String str3);
}
