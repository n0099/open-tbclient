package com.baidu.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class b extends AbstractHttpMessageConverter<Object> {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3748a = Charset.forName("UTF-8");

    private Charset a(com.baidu.apollon.restnet.http.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
            return Charset.forName(aVar.j());
        }
        return f3748a;
    }

    @Override // com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        String copyToString = FileCopyUtils.copyToString(new InputStreamReader(eVar.c(), a(eVar.d())));
        a(copyToString);
        return copyToString;
    }
}
