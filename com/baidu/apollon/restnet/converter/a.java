package com.baidu.apollon.restnet.converter;

import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class a extends AbstractHttpMessageConverter<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter
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
