package com.baidu.swan.games.k;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes2.dex */
public class c {
    public int bio;
    public String bip;
    public String bil = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean bim = false;
    public boolean bin = false;

    public boolean g(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.bil = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.bim = cVar.optBoolean("multiple");
            this.bin = cVar.optBoolean("confirmHold");
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
                    this.bio = 6;
                    this.bip = "done";
                    return true;
                case 1:
                    this.bio = 5;
                    this.bip = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.bio = 3;
                    this.bip = "search";
                    return true;
                case 3:
                    this.bio = 2;
                    this.bip = "go";
                    return true;
                case 4:
                    this.bio = 4;
                    this.bip = "send";
                    return true;
                default:
                    this.bio = 6;
                    this.bip = "done";
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
