package com.baidu.swan.games.k;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public String bjA;
    public int bjz;
    public String bjw = "";
    public int maxLength = Integer.MAX_VALUE;
    public boolean bjx = false;
    public boolean bjy = false;

    public boolean g(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bjw = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bjx = cVar.optBoolean("multiple");
            this.bjy = cVar.optBoolean("confirmHold");
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
                    this.bjz = 6;
                    this.bjA = "done";
                    return true;
                case 1:
                    this.bjz = 5;
                    this.bjA = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bjz = 3;
                    this.bjA = "search";
                    return true;
                case 3:
                    this.bjz = 2;
                    this.bjA = "go";
                    return true;
                case 4:
                    this.bjz = 4;
                    this.bjA = "send";
                    return true;
                default:
                    this.bjz = 6;
                    this.bjA = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
