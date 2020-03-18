package com.baidu.swan.games.m;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class c {
    public int cpV;
    public String cpW;
    public String cpS = "";
    public int maxLength = Integer.MAX_VALUE;
    public boolean cpT = false;
    public boolean cpU = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.cpS = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.cpT = cVar.optBoolean("multiple");
            this.cpU = cVar.optBoolean("confirmHold");
            String optString = cVar.optString("confirmType");
            char c = 65535;
            switch (optString.hashCode()) {
                case -906336856:
                    if (optString.equals("search")) {
                        c = 2;
                        break;
                    }
                    break;
                case 3304:
                    if (optString.equals("go")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3089282:
                    if (optString.equals(AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE)) {
                        c = 0;
                        break;
                    }
                    break;
                case 3377907:
                    if (optString.equals(UnitedSchemeConstants.UNITED_SCHEME_NEXT)) {
                        c = 1;
                        break;
                    }
                    break;
                case 3526536:
                    if (optString.equals("send")) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.cpV = 6;
                    this.cpW = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.cpV = 5;
                    this.cpW = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.cpV = 3;
                    this.cpW = "search";
                    return true;
                case 3:
                    this.cpV = 2;
                    this.cpW = "go";
                    return true;
                case 4:
                    this.cpV = 4;
                    this.cpW = "send";
                    return true;
                default:
                    this.cpV = 6;
                    this.cpW = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
