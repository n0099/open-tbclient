package com.baidu.swan.games.n;

import android.support.v7.widget.ActivityChooserView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.minivideo.plugin.capture.db.AuthoritySharedPreferences;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import com.baidu.swan.games.binding.model.JSTypeMismatchException;
/* loaded from: classes11.dex */
public class c {
    public int deD;
    public String deE;
    public String deA = "";
    public int maxLength = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    public boolean deB = false;
    public boolean deC = false;

    public boolean h(com.baidu.swan.games.binding.model.c cVar) throws JSTypeMismatchException {
        try {
            this.deA = cVar.optString("defaultValue");
            this.maxLength = cVar.optInt("maxLength");
            this.deB = cVar.optBoolean("multiple");
            this.deC = cVar.optBoolean("confirmHold");
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
                    this.deD = 6;
                    this.deE = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
                case 1:
                    this.deD = 5;
                    this.deE = UnitedSchemeConstants.UNITED_SCHEME_NEXT;
                    return true;
                case 2:
                    this.deD = 3;
                    this.deE = "search";
                    return true;
                case 3:
                    this.deD = 2;
                    this.deE = "go";
                    return true;
                case 4:
                    this.deD = 4;
                    this.deE = UbcStatConstant.ContentType.UBC_TYPE_IM_SEND;
                    return true;
                default:
                    this.deD = 6;
                    this.deE = AuthoritySharedPreferences.KEY_CONFIG_PRIVILEGE_DONE;
                    return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
