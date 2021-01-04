package com.baidu.swan.games.n;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes9.dex */
public class c {
    public int elc;
    public String eld;
    public String ekZ = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean ela = false;
    public boolean elb = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.ekZ = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.ela = cVar.optBoolean("multiple");
            this.elb = cVar.optBoolean("confirmHold");
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
                    if (optString.equals(UbcStatConstant.ContentType.UBC_TYPE_IM_SEND)) {
                        c = 4;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.elc = 6;
                    this.eld = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.elc = 5;
                    this.eld = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.elc = 3;
                    this.eld = "search";
                    return true;
                case 3:
                    this.elc = 2;
                    this.eld = "go";
                    return true;
                case 4:
                    this.elc = 4;
                    this.eld = UbcStatConstant.ContentType.UBC_TYPE_IM_SEND;
                    return true;
                default:
                    this.elc = 6;
                    this.eld = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
