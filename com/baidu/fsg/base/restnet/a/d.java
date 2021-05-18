package com.baidu.fsg.base.restnet.a;

import android.text.TextUtils;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
/* loaded from: classes2.dex */
public class d extends a<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5200a = Charset.forName("UTF-8");

    private Charset a(com.baidu.fsg.base.restnet.http.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
            return Charset.forName(aVar.j());
        }
        return f5200a;
    }

    @Override // com.baidu.fsg.base.restnet.a.a
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        return FileCopyUtils.copyToString(new InputStreamReader(eVar.c(), a(eVar.d())));
    }
}
