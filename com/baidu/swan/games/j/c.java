package com.baidu.swan.games.j;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bdX;
    public String bdY;
    public String bdU = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean bdV = false;
    public boolean bdW = false;

    public boolean c(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bdU = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bdV = cVar.optBoolean("multiple");
            this.bdW = cVar.optBoolean("confirmHold");
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
                    this.bdX = 6;
                    this.bdY = "done";
                    return true;
                case 1:
                    this.bdX = 5;
                    this.bdY = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bdX = 3;
                    this.bdY = "search";
                    return true;
                case 3:
                    this.bdX = 2;
                    this.bdY = "go";
                    return true;
                case 4:
                    this.bdX = 4;
                    this.bdY = "send";
                    return true;
                default:
                    this.bdX = 6;
                    this.bdY = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
