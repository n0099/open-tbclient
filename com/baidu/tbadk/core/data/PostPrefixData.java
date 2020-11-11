package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;
import tbclient.FrsPage.PostPrefix;
/* loaded from: classes.dex */
public class PostPrefixData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 6807267689393049879L;
    private String implicitTitle;
    private ArrayList<String> prefixs = new ArrayList<>();

    public void parserJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt(UbcStatConstant.KEY_CONTENT_EXT_MODE, 0);
            if (optInt == 0) {
                String optString = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString)) {
                    this.prefixs.add(optString);
                }
            } else if (optInt == 1) {
                String optString2 = jSONObject.optString("text");
                if (!TextUtils.isEmpty(optString2)) {
                    String optString3 = jSONObject.optString("type");
                    if (!TextUtils.isEmpty(optString3)) {
                        String[] split = optString3.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i].trim())) {
                                this.prefixs.add(optString2.replace("#type#", split[i]));
                            }
                        }
                        return;
                    }
                    this.prefixs.add(optString2);
                }
            }
        }
    }

    public ArrayList<String> getPrefixs() {
        return this.prefixs;
    }

    public void parserProtobuf(PostPrefix postPrefix) {
        if (postPrefix != null) {
            int intValue = postPrefix.mode.intValue();
            if (intValue == 0) {
                String str = postPrefix.text;
                if (!TextUtils.isEmpty(str)) {
                    this.prefixs.add(str);
                }
            } else if (intValue == 1) {
                String str2 = postPrefix.text;
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = postPrefix.type;
                    if (!TextUtils.isEmpty(str3)) {
                        String[] split = str3.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i].trim())) {
                                this.prefixs.add(str2.replace("#type#", split[i]));
                            }
                        }
                        return;
                    }
                    this.prefixs.add(str2);
                }
            }
        }
    }

    public void parserProtobuf(tbclient.PostPrefix postPrefix) {
        if (postPrefix != null) {
            int intValue = postPrefix.mode.intValue();
            if (intValue == 0) {
                String str = postPrefix.text;
                if (!TextUtils.isEmpty(str)) {
                    this.prefixs.add(str);
                }
            } else if (intValue == 1) {
                String str2 = postPrefix.text;
                if (!TextUtils.isEmpty(str2)) {
                    String str3 = postPrefix.type;
                    if (!TextUtils.isEmpty(str3)) {
                        String[] split = str3.split(" ");
                        for (int i = 0; i < split.length; i++) {
                            if (!TextUtils.isEmpty(split[i].trim())) {
                                this.prefixs.add(str2.replace("#type#", split[i]));
                            }
                        }
                        return;
                    }
                    this.prefixs.add(str2);
                }
            }
        }
    }

    public String getImplicitTitle() {
        return this.implicitTitle;
    }

    public void setImplicitTitle(String str) {
        this.implicitTitle = str;
    }

    public void addPreFix(String str) {
        this.prefixs.add(str);
    }
}
