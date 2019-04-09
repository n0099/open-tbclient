package com.baidu.swan.games.j;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bdY;
    public String bdZ;
    public String bdV = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean bdW = false;
    public boolean bdX = false;

    public boolean c(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bdV = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bdW = cVar.optBoolean("multiple");
            this.bdX = cVar.optBoolean("confirmHold");
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
                    this.bdY = 6;
                    this.bdZ = "done";
                    return true;
                case 1:
                    this.bdY = 5;
                    this.bdZ = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bdY = 3;
                    this.bdZ = "search";
                    return true;
                case 3:
                    this.bdY = 2;
                    this.bdZ = "go";
                    return true;
                case 4:
                    this.bdY = 4;
                    this.bdZ = "send";
                    return true;
                default:
                    this.bdY = 6;
                    this.bdZ = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
