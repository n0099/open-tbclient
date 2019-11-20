package com.baidu.swan.games.k;

import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bBw;
    public String bBx;
    public String bBt = "";
    public int maxLength = Integer.MAX_VALUE;
    public boolean bBu = false;
    public boolean bBv = false;

    public boolean g(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bBt = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bBu = cVar.optBoolean("multiple");
            this.bBv = cVar.optBoolean("confirmHold");
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
                    this.bBw = 6;
                    this.bBx = "done";
                    return true;
                case 1:
                    this.bBw = 5;
                    this.bBx = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bBw = 3;
                    this.bBx = "search";
                    return true;
                case 3:
                    this.bBw = 2;
                    this.bBx = "go";
                    return true;
                case 4:
                    this.bBw = 4;
                    this.bBx = "send";
                    return true;
                default:
                    this.bBw = 6;
                    this.bBx = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
