package com.baidu.swan.games.k;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bCn;
    public String bCo;
    public String bCk = "";
    public int maxLength = Integer.MAX_VALUE;
    public boolean bCl = false;
    public boolean bCm = false;

    public boolean g(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bCk = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bCl = cVar.optBoolean("multiple");
            this.bCm = cVar.optBoolean("confirmHold");
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
                    if (optString.equals("done")) {
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
                    this.bCn = 6;
                    this.bCo = "done";
                    return true;
                case 1:
                    this.bCn = 5;
                    this.bCo = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bCn = 3;
                    this.bCo = "search";
                    return true;
                case 3:
                    this.bCn = 2;
                    this.bCo = "go";
                    return true;
                case 4:
                    this.bCn = 4;
                    this.bCo = "send";
                    return true;
                default:
                    this.bCn = 6;
                    this.bCo = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
