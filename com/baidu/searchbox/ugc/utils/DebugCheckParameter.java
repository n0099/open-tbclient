package com.baidu.searchbox.ugc.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.ugc.model.ReferenceDt;
/* loaded from: classes12.dex */
public class DebugCheckParameter {
    public static final boolean DEBUG = AppConfig.isDebug();

    public static void checkCallerParameter(Context context, String str, int i, String str2, ReferenceDt referenceDt) {
        if (DEBUG) {
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                sb.append("TopicSelectPageScheme,");
            }
            if (i == 5) {
                if (TextUtils.isEmpty(str2)) {
                    sb.append("\nmForwardContent,");
                }
                if (referenceDt == null) {
                    sb.append("\nReferenceDt,");
                } else {
                    if (TextUtils.isEmpty(referenceDt.url)) {
                        sb.append("\nReferenceDt.url,");
                    }
                    if (TextUtils.isEmpty(referenceDt.id)) {
                        sb.append("\nReferenceDt.id,");
                    }
                    if (TextUtils.isEmpty(referenceDt.refType)) {
                        sb.append("\nReferenceDt.refType,");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.insert(0, "Debug时期提示:");
                sb.append("\nis empty");
                Toast.makeText(context, sb.toString(), 1).show();
            }
        }
    }
}
