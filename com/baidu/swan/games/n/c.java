package com.baidu.swan.games.n;

import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes8.dex */
public class c {
    public int egq;
    public String egr;
    public String egn = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean ego = false;
    public boolean egp = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.egn = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.ego = cVar.optBoolean("multiple");
            this.egp = cVar.optBoolean("confirmHold");
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
                    this.egq = 6;
                    this.egr = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.egq = 5;
                    this.egr = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.egq = 3;
                    this.egr = "search";
                    return true;
                case 3:
                    this.egq = 2;
                    this.egr = "go";
                    return true;
                case 4:
                    this.egq = 4;
                    this.egr = UbcStatConstant.ContentType.UBC_TYPE_IM_SEND;
                    return true;
                default:
                    this.egq = 6;
                    this.egr = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
