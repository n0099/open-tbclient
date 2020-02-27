package com.baidu.down.loopj.android.http;

import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.utils.URLEncodedUtils;
import com.baidu.webkit.internal.ETAG;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class RequestParams {
    private static String ENCODING = "UTF-8";
    protected ConcurrentHashMap<String, FileWrapper> fileParams;
    protected ConcurrentHashMap<String, String> urlParams;
    protected ConcurrentHashMap<String, ArrayList<String>> urlParamsWithArray;

    public RequestParams() {
        init();
    }

    public RequestParams(Map<String, String> map) {
        init();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public RequestParams(String str, String str2) {
        init();
        put(str, str2);
    }

    public RequestParams(Object... objArr) {
        init();
        int length = objArr.length;
        if (length % 2 != 0) {
            throw new IllegalArgumentException("Supplied arguments must be even");
        }
        for (int i = 0; i < length; i += 2) {
            put(String.valueOf(objArr[i]), String.valueOf(objArr[i + 1]));
        }
    }

    public void put(String str, String str2) {
        if (str != null && str2 != null) {
            this.urlParams.put(str, str2);
        }
    }

    public void put(String str, File file) throws FileNotFoundException {
        put(str, new FileInputStream(file), file.getName());
    }

    public void put(String str, ArrayList<String> arrayList) {
        if (str != null && arrayList != null) {
            this.urlParamsWithArray.put(str, arrayList);
        }
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        put(str, inputStream, str2, null);
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        if (str != null && inputStream != null) {
            this.fileParams.put(str, new FileWrapper(inputStream, str2, str3));
        }
    }

    public void remove(String str) {
        this.urlParams.remove(str);
        this.fileParams.remove(str);
        this.urlParamsWithArray.remove(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(entry.getKey());
            sb.append(ETAG.EQUAL);
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, FileWrapper> entry2 : this.fileParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            sb.append(entry2.getKey());
            sb.append(ETAG.EQUAL);
            sb.append("FILE");
        }
        for (Map.Entry<String, ArrayList<String>> entry3 : this.urlParamsWithArray.entrySet()) {
            if (sb.length() > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
            }
            ArrayList<String> value = entry3.getValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < value.size()) {
                    if (i2 != 0) {
                        sb.append(ETAG.ITEM_SEPARATOR);
                    }
                    sb.append(entry3.getKey());
                    sb.append(ETAG.EQUAL);
                    sb.append(value.get(i2));
                    i = i2 + 1;
                }
            }
        }
        return sb.toString();
    }

    private void init() {
        this.urlParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.urlParamsWithArray = new ConcurrentHashMap<>();
    }

    protected List<BasicNameValuePair> getParamsList() {
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : this.urlParams.entrySet()) {
            linkedList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
        }
        for (Map.Entry<String, ArrayList<String>> entry2 : this.urlParamsWithArray.entrySet()) {
            Iterator<String> it = entry2.getValue().iterator();
            while (it.hasNext()) {
                linkedList.add(new BasicNameValuePair(entry2.getKey(), it.next()));
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), ENCODING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class FileWrapper {
        public String contentType;
        public String fileName;
        public InputStream inputStream;

        public FileWrapper(InputStream inputStream, String str, String str2) {
            this.inputStream = inputStream;
            this.fileName = str;
            this.contentType = str2;
        }

        public String getFileName() {
            return this.fileName != null ? this.fileName : "nofilename";
        }
    }
}
