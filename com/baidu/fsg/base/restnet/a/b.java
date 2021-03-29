package com.baidu.fsg.base.restnet.a;

import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class b extends a<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.a.a
    /* renamed from: c */
    public byte[] b(Class<?> cls, e eVar) throws IOException {
        long h2 = eVar.d().h();
        if (h2 >= 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) h2);
            FileCopyUtils.copy(eVar.c(), byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return FileCopyUtils.copyToByteArray(eVar.c());
    }
}
