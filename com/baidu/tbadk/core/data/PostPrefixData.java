package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes3.dex */
public class PostPrefixData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 6807267689393049879L;
    public String implicitTitle;
    public ArrayList<String> prefixs = new ArrayList<>();

    public void addPreFix(String str) {
        this.prefixs.add(str);
    }

    public String getImplicitTitle() {
        return this.implicitTitle;
    }

    public ArrayList<String> getPrefixs() {
        return this.prefixs;
    }

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("mode", 0);
        if (optInt == 0) {
            String optString = jSONObject.optString("text");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            this.prefixs.add(optString);
        } else if (optInt == 1) {
            String optString2 = jSONObject.optString("text");
            if (TextUtils.isEmpty(optString2)) {
                return;
            }
            String optString3 = jSONObject.optString("type");
            if (!TextUtils.isEmpty(optString3)) {
                String[] split = optString3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(optString2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(optString2);
        }
    }

    public void parserProtobuf(PostPrefix postPrefix) {
        if (postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        if (intValue == 0) {
            String str = postPrefix.text;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.prefixs.add(str);
        } else if (intValue == 1) {
            String str2 = postPrefix.text;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = postPrefix.type;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(str2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(str2);
        }
    }

    public void setImplicitTitle(String str) {
        this.implicitTitle = str;
    }

    public void parserProtobuf(tbclient.PostPrefix postPrefix) {
        if (postPrefix == null) {
            return;
        }
        int intValue = postPrefix.mode.intValue();
        if (intValue == 0) {
            String str = postPrefix.text;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.prefixs.add(str);
        } else if (intValue == 1) {
            String str2 = postPrefix.text;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String str3 = postPrefix.type;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(" ");
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!TextUtils.isEmpty(split[i2].trim())) {
                        this.prefixs.add(str2.replace("#type#", split[i2]));
                    }
                }
                return;
            }
            this.prefixs.add(str2);
        }
    }
}
