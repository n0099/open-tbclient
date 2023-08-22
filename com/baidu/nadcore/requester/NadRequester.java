package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.sj0;
import com.baidu.tieba.u21;
import java.util.List;
/* loaded from: classes3.dex */
public class NadRequester {
    public static final u21 a;

    /* loaded from: classes3.dex */
    public class a implements u21 {
        @Override // com.baidu.tieba.u21
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
        u21 u21Var = (u21) ServiceManager.getService(u21.a);
        if (u21Var == null) {
            u21Var = new a();
        }
        a = u21Var;
    }

    public static void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        if (sj0.a().B()) {
            a.a(requestParameters, bVar);
        } else {
            bVar.a(new Error("Blocked by client"));
        }
    }
}
