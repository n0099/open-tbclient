package com.baidu.searchbox.ng.ai.apps.contact.action;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.contact.ContactParams;
import com.baidu.searchbox.ng.ai.apps.runtime.AiApp;
import com.baidu.searchbox.ng.ai.apps.scheme.UnitedSchemeAiAppDispatcher;
import com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class SetPhoneContactAction extends AiAppAction {
    private static final String ACTION_EDIT = "edit";
    private static final String ACTION_INSERT = "insert";
    private static final String KEY_ACTION = "action";
    private static final String KEY_CALLBACK = "cb";
    public static final String MODULE_NAME = "/swan/setPhoneContact";
    private static final String TAG = "SetPhoneContactAction";
    private String callback;

    public SetPhoneContactAction(UnitedSchemeAiAppDispatcher unitedSchemeAiAppDispatcher) {
        super(unitedSchemeAiAppDispatcher, MODULE_NAME);
    }

    @Override // com.baidu.searchbox.ng.ai.apps.scheme.actions.AiAppAction
    public boolean handle(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, AiApp aiApp) {
        if (context == null || callbackHandler == null || aiApp == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
            return false;
        }
        JSONObject optParamsAsJo = UnitedSchemeUtility.optParamsAsJo(unitedSchemeEntity);
        if (optParamsAsJo == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
            return false;
        }
        String optString = optParamsAsJo.optString("action");
        if (TextUtils.isEmpty(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        ContactParams createFromJSON = ContactParams.createFromJSON(optParamsAsJo);
        if (!createFromJSON.isValid()) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            return false;
        }
        this.callback = optParamsAsJo.optString("cb");
        char c = 65535;
        switch (optString.hashCode()) {
            case -1183792455:
                if (optString.equals(ACTION_INSERT)) {
                    c = 0;
                    break;
                }
                break;
            case 3108362:
                if (optString.equals(ACTION_EDIT)) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                insert(context, createFromJSON, callbackHandler);
                return true;
            case 1:
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                edit(context, createFromJSON, callbackHandler);
                return true;
            default:
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                return false;
        }
    }

    private void insert(Context context, ContactParams contactParams, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT", Uri.withAppendedPath(Uri.parse("content://com.android.contacts"), "contacts"));
        intent.putExtra("name", contactParams.getDisplayName());
        intent.putExtra("email", contactParams.email);
        intent.putParcelableArrayListExtra("data", getContactData(contactParams));
        intent.setFlags(268435456);
        startContactActivity(context, intent, callbackHandler);
    }

    private void edit(Context context, ContactParams contactParams, CallbackHandler callbackHandler) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("name", contactParams.getDisplayName());
        intent.putExtra("email", contactParams.email);
        intent.putParcelableArrayListExtra("data", getContactData(contactParams));
        intent.setFlags(268435456);
        startContactActivity(context, intent, callbackHandler);
    }

    private void startContactActivity(Context context, Intent intent, CallbackHandler callbackHandler) {
        try {
            context.startActivity(intent);
            if (!TextUtils.isEmpty(this.callback)) {
                callbackHandler.handleSchemeDispatchCallback(this.callback, UnitedSchemeUtility.wrapCallbackParams(0, "ok").toString());
            }
        } catch (Exception e) {
            if (!TextUtils.isEmpty(this.callback)) {
                callbackHandler.handleSchemeDispatchCallback(this.callback, UnitedSchemeUtility.wrapCallbackParams(201, "fail startactivity exception").toString());
            }
        }
    }

    private ArrayList<ContentValues> getContactData(ContactParams contactParams) {
        ArrayList<ContentValues> arrayList = new ArrayList<>(16);
        arrayList.add(contactParams.getMobilePhoneNumberData());
        arrayList.add(contactParams.getHomePhoneNumberData());
        arrayList.add(contactParams.getWorkPhoneNumberData());
        arrayList.add(contactParams.getHostNumberData());
        arrayList.add(contactParams.getHomeFaxNumberData());
        arrayList.add(contactParams.getWorkFaxNumberData());
        arrayList.add(contactParams.getNickNameData());
        arrayList.add(contactParams.getWeChatNumberData());
        arrayList.add(contactParams.getUrlData());
        arrayList.add(contactParams.getRemarkData());
        arrayList.add(contactParams.getOrganizationData());
        arrayList.add(contactParams.getAddressData());
        arrayList.add(contactParams.getWorkAddressData());
        arrayList.add(contactParams.getHomeAddressData());
        return arrayList;
    }
}
