package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.o31;
import com.baidu.tieba.rk0;
import java.util.List;
/* loaded from: classes3.dex */
public class NadRequester {
    public static final o31 a;

    /* loaded from: classes3.dex */
    public class a implements o31 {
        @Override // com.baidu.tieba.o31
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
        o31 o31Var = (o31) ServiceManager.getService(o31.a);
        if (o31Var == null) {
            o31Var = new a();
        }
        a = o31Var;
    }

    public static void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        if (rk0.a().B()) {
            a.a(requestParameters, bVar);
        } else {
            bVar.a(new Error("Blocked by client"));
        }
    }
}
