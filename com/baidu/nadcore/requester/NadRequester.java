package com.baidu.nadcore.requester;

import androidx.annotation.NonNull;
import com.baidu.nadcore.model.AdBaseModel;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tieba.tj0;
import com.baidu.tieba.y21;
import java.util.List;
/* loaded from: classes3.dex */
public class NadRequester {
    public static final y21 a;

    /* loaded from: classes3.dex */
    public class a implements y21 {
        @Override // com.baidu.tieba.y21
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
        y21 y21Var = (y21) ServiceManager.getService(y21.a);
        if (y21Var == null) {
            y21Var = new a();
        }
        a = y21Var;
    }

    public static void a(@NonNull RequestParameters requestParameters, @NonNull b bVar) {
        if (tj0.a().B()) {
            a.a(requestParameters, bVar);
        } else {
            bVar.a(new Error("Blocked by client"));
        }
    }
}
