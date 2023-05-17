package com.baidu.searchbox.network.outback.core;

import androidx.annotation.Nullable;
import com.baidu.searchbox.network.outback.core.internal.Util;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class FormBody extends RequestBody {
    public static final MediaType CONTENT_TYPE = MediaType.get("application/x-www-form-urlencoded");
    public final List<String> encodedNames;
    public final List<String> encodedValues;

    /* loaded from: classes3.dex */
    public static final class Builder {
        public final Charset charset;
        public final List<String> names;
        public final List<String> values;

        public Builder() {
            this(null);
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public Builder(Charset charset) {
            this.names = new ArrayList();
            this.values = new ArrayList();
            this.charset = charset;
        }

        public Builder add(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                    this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.charset));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }

        public Builder addEncoded(String str, String str2) {
            if (str != null) {
                if (str2 != null) {
                    this.names.add(HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                    this.values.add(HttpUrl.canonicalize(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.charset));
                    return this;
                }
                throw new NullPointerException("value == null");
            }
            throw new NullPointerException("name == null");
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public long contentLength() {
        try {
            return writeOrCountBytes(null, true);
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    public int size() {
        return this.encodedNames.size();
    }

    public FormBody(List<String> list, List<String> list2) {
        this.encodedNames = Util.immutableList(list);
        this.encodedValues = Util.immutableList(list2);
    }

    private long writeOrCountBytes(@Nullable OutputStream outputStream, boolean z) throws IOException {
        if (z) {
            outputStream = new ByteArrayOutputStream();
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bufferedOutputStream.write(38);
            }
            Util.writeUtf8(bufferedOutputStream, this.encodedNames.get(i));
            bufferedOutputStream.write(61);
            Util.writeUtf8(bufferedOutputStream, this.encodedValues.get(i));
        }
        bufferedOutputStream.flush();
        if (z) {
            return ((ByteArrayOutputStream) outputStream).size();
        }
        return 0L;
    }

    public String encodedName(int i) {
        return this.encodedNames.get(i);
    }

    public String encodedValue(int i) {
        return this.encodedValues.get(i);
    }

    public String name(int i) {
        return HttpUrl.percentDecode(encodedName(i), true);
    }

    public String value(int i) {
        return HttpUrl.percentDecode(encodedValue(i), true);
    }

    @Override // com.baidu.searchbox.network.outback.core.RequestBody
    public void writeTo(OutputStream outputStream) throws IOException {
        writeOrCountBytes(outputStream, false);
    }
}
