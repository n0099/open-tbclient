package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.ey0;
import com.baidu.tieba.hf0;
import java.util.List;
/* loaded from: classes3.dex */
public class NadRequester {
    public static final ey0 a;

    /* loaded from: classes3.dex */
    public class a implements ey0 {
        @Override // com.baidu.tieba.ey0
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
        ey0 ey0Var = (ey0) ServiceManager.getService(ey0.a);
        if (ey0Var == null) {
            ey0Var = new a();
        }
        a = ey0Var;
    }

    public static void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        if (hf0.a().C()) {
            a.a(requestParameters, bVar);
        } else {
            bVar.a(new Error("Blocked by client"));
        }
    }
}
