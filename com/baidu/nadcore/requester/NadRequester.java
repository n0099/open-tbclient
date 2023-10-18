package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.kx0;
import com.baidu.tieba.pe0;
import java.util.List;
/* loaded from: classes3.dex */
public class NadRequester {
    public static final kx0 a;

    /* loaded from: classes3.dex */
    public class a implements kx0 {
        @Override // com.baidu.tieba.kx0
        public void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(@NonNull Error error);

        void b(@NonNull List<AdBaseModel> list);
    }

    /* loaded from: classes3.dex */
    public static final class Error extends Exception {
        public Error() {
        }

        public Error(String str) {
            super(str);
        }

        public Error(String str, Throwable th) {
            super(str, th);
        }

        public Error(Throwable th) {
            super(th);
        }
    }

    static {
        kx0 kx0Var = (kx0) ServiceManager.getService(kx0.a);
        if (kx0Var == null) {
            kx0Var = new a();
        }
        a = kx0Var;
    }

    public static void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        if (pe0.a().C()) {
            a.a(requestParameters, bVar);
        } else {
            bVar.a(new Error("Blocked by client"));
        }
    }
}
