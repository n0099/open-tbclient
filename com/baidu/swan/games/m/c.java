package com.baidu.swan.games.m;

import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class c {
    public int cpI;
    public String cpJ;
    public String cpF = "";
    public int maxLength = Integer.MAX_VALUE;
    public boolean cpG = false;
    public boolean cpH = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.cpF = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.cpG = cVar.optBoolean("multiple");
            this.cpH = cVar.optBoolean("confirmHold");
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
                    this.cpI = 6;
                    this.cpJ = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.cpI = 5;
                    this.cpJ = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.cpI = 3;
                    this.cpJ = "search";
                    return true;
                case 3:
                    this.cpI = 2;
                    this.cpJ = "go";
                    return true;
                case 4:
                    this.cpI = 4;
                    this.cpJ = "send";
                    return true;
                default:
                    this.cpI = 6;
                    this.cpJ = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
