package com.baidu.down.loopj.android.http;

import com.baidu.down.common.BasicNameValuePair;
import com.baidu.down.utils.URLEncodedUtils;
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
/* loaded from: classes2.dex */
public class RequestParams {
    public static String ENCODING = "UTF-8";
    public ConcurrentHashMap<String, FileWrapper> fileParams;
    public ConcurrentHashMap<String, String> urlParams;
    public ConcurrentHashMap<String, ArrayList<String>> urlParamsWithArray;

    /* loaded from: classes2.dex */
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
            String str = this.fileName;
            return str != null ? str : "nofilename";
        }
    }

    public RequestParams() {
        init();
    }

    private void init() {
        this.urlParams = new ConcurrentHashMap<>();
        this.fileParams = new ConcurrentHashMap<>();
        this.urlParamsWithArray = new ConcurrentHashMap<>();
    }

    public String getParamString() {
        return URLEncodedUtils.format(getParamsList(), ENCODING);
    }

    public List<BasicNameValuePair> getParamsList() {
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

    public void put(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.urlParams.put(str, str2);
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
                sb.append("&");
            }
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
        }
        for (Map.Entry<String, FileWrapper> entry2 : this.fileParams.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry2.getKey());
            sb.append("=");
            sb.append("FILE");
        }
        for (Map.Entry<String, ArrayList<String>> entry3 : this.urlParamsWithArray.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            ArrayList<String> value = entry3.getValue();
            for (int i2 = 0; i2 < value.size(); i2++) {
                if (i2 != 0) {
                    sb.append("&");
                }
                sb.append(entry3.getKey());
                sb.append("=");
                sb.append(value.get(i2));
            }
        }
        return sb.toString();
    }

    public void put(String str, File file) throws FileNotFoundException {
        put(str, new FileInputStream(file), file.getName());
    }

    public RequestParams(Map<String, String> map) {
        init();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void put(String str, ArrayList<String> arrayList) {
        if (str == null || arrayList == null) {
            return;
        }
        this.urlParamsWithArray.put(str, arrayList);
    }

    public void put(String str, InputStream inputStream) {
        put(str, inputStream, null);
    }

    public void put(String str, InputStream inputStream, String str2) {
        put(str, inputStream, str2, null);
    }

    public void put(String str, InputStream inputStream, String str2, String str3) {
        if (str == null || inputStream == null) {
            return;
        }
        this.fileParams.put(str, new FileWrapper(inputStream, str2, str3));
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
        for (int i2 = 0; i2 < length; i2 += 2) {
            put(String.valueOf(objArr[i2]), String.valueOf(objArr[i2 + 1]));
        }
    }
}
