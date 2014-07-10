package com.baidu.tbadk.core.log;

import android.os.Build;
import android.text.TextUtils;
import android.text.format.DateFormat;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class LoggerItem extends LinkedHashMap<String, String> {
    private static String a = "yyyy-MM-dd kk:mm:ss";
    private static final long serialVersionUID = 5970126981799423191L;
    private String mType;

    public LoggerItem(String str) {
        this.mType = h.a;
        this.mType = str;
    }

    public void addRange(LoggerItem loggerItem) {
        for (String str : loggerItem.keySet()) {
            put(str, loggerItem.get(str));
        }
    }

    public void initBaseData() {
        String currentAccount = TbadkApplication.getCurrentAccount();
        String version = TbConfig.getVersion();
        String charSequence = DateFormat.format(a, System.currentTimeMillis()).toString();
        String uniqueIdentifier = TbadkApplication.getUniqueIdentifier();
        String str = Build.MODEL;
        String b = g.b();
        put("logtype", TextUtils.isEmpty(this.mType) ? "" : this.mType);
        put("time", TextUtils.isEmpty(charSequence) ? "" : charSequence);
        put("cuid", TextUtils.isEmpty(uniqueIdentifier) ? "" : uniqueIdentifier);
        put("model", TextUtils.isEmpty(str) ? "" : str);
        put("network", TextUtils.isEmpty(b) ? "" : b);
        put(SapiAccountManager.SESSION_UID, TextUtils.isEmpty(currentAccount) ? "" : currentAccount);
        put("version", TextUtils.isEmpty(version) ? "" : version);
    }

    public synchronized String mergeString(String str) {
        return convertToString(str);
    }

    @Override // java.util.AbstractMap
    public synchronized String toString() {
        return convertToString(null);
    }

    public String convertToString(String str) {
        StringBuilder sb = new StringBuilder(256);
        int i = 0;
        Iterator it = keySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            String str2 = (String) it.next();
            sb.append(String.valueOf(i2 > 0 ? "\t" : "") + str2 + "=" + ((String) get(str2)));
            i = i2 + 1;
        }
        if (!TextUtils.isEmpty(str)) {
            sb.append(String.valueOf(sb.length() > 0 ? "\t" : "") + str);
        } else {
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    public String getType() {
        return this.mType;
    }
}
