package com.baidu.swan.games.j;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bdU;
    public String bdV;
    public String bdR = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean bdS = false;
    public boolean bdT = false;

    public boolean c(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bdR = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bdS = cVar.optBoolean("multiple");
            this.bdT = cVar.optBoolean("confirmHold");
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
                    this.bdU = 6;
                    this.bdV = "done";
                    return true;
                case 1:
                    this.bdU = 5;
                    this.bdV = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bdU = 3;
                    this.bdV = "search";
                    return true;
                case 3:
                    this.bdU = 2;
                    this.bdV = "go";
                    return true;
                case 4:
                    this.bdU = 4;
                    this.bdV = "send";
                    return true;
                default:
                    this.bdU = 6;
                    this.bdV = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
