package com.baidu.swan.games.k;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bjb;
    public String bjc;
    public String biY = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean biZ = false;
    public boolean bja = false;

    public boolean g(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.biY = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.biZ = cVar.optBoolean("multiple");
            this.bja = cVar.optBoolean("confirmHold");
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
                    this.bjb = 6;
                    this.bjc = "done";
                    return true;
                case 1:
                    this.bjb = 5;
                    this.bjc = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bjb = 3;
                    this.bjc = "search";
                    return true;
                case 3:
                    this.bjb = 2;
                    this.bjc = "go";
                    return true;
                case 4:
                    this.bjb = 4;
                    this.bjc = "send";
                    return true;
                default:
                    this.bjb = 6;
                    this.bjc = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
