package com.baidu.swan.games.n;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes10.dex */
public class c {
    public int dWP;
    public String dWQ;
    public String dWM = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean dWN = false;
    public boolean dWO = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.dWM = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.dWN = cVar.optBoolean("multiple");
            this.dWO = cVar.optBoolean("confirmHold");
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
                    this.dWP = 6;
                    this.dWQ = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.dWP = 5;
                    this.dWQ = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.dWP = 3;
                    this.dWQ = "search";
                    return true;
                case 3:
                    this.dWP = 2;
                    this.dWQ = "go";
                    return true;
                case 4:
                    this.dWP = 4;
                    this.dWQ = UbcStatConstant.ContentType.UBC_TYPE_IM_SEND;
                    return true;
                default:
                    this.dWP = 6;
                    this.dWQ = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
