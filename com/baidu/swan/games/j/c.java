package com.baidu.swan.games.j;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bdT;
    public String bdU;
    public String bdQ = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean bdR = false;
    public boolean bdS = false;

    public boolean c(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bdQ = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bdR = cVar.optBoolean("multiple");
            this.bdS = cVar.optBoolean("confirmHold");
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
                    this.bdT = 6;
                    this.bdU = "done";
                    return true;
                case 1:
                    this.bdT = 5;
                    this.bdU = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bdT = 3;
                    this.bdU = "search";
                    return true;
                case 3:
                    this.bdT = 2;
                    this.bdU = "go";
                    return true;
                case 4:
                    this.bdT = 4;
                    this.bdU = "send";
                    return true;
                default:
                    this.bdT = 6;
                    this.bdU = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
