package com.baidu.android.nebula.cmd;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentUris;
import android.content.Context;
import android.content.UriMatcher;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.baidu.android.moplus.util.NoProGuard;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AddContactInfo implements NoProGuard, d {
    private static final boolean DEBUG = false;
    private static final int ERROR_WRITE_FAILED = 5;
    private static final String TAG = "AddContactInfo";
    private ArrayList mContacts;
    private Context mContext;
    private int mErrcode = 0;

    public AddContactInfo() {
        a.a();
        a.a(TAG);
    }

    public ArrayList applyBatchInsert(ArrayList arrayList) {
        ContentProviderResult[] applyBatch;
        Long.valueOf(Calendar.getInstance().getTimeInMillis());
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            com.baidu.android.nebula.cmd.a.b bVar = (com.baidu.android.nebula.cmd.a.b) arrayList.get(i);
            int size = arrayList2.size();
            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI).withValue("starred", Integer.valueOf(bVar.b)).build());
            if (!TextUtils.isEmpty(bVar.a)) {
                arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("data1", bVar.a).withValue("mimetype", "vnd.android.cursor.item/name").build());
            }
            List list = bVar.c;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a != null) {
                        if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("phone")) {
                            com.baidu.android.nebula.cmd.a.a aVar = (com.baidu.android.nebula.cmd.a.a) list.get(i2);
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/phone_v2").withValue("data1", aVar.d).withValue("data2", Integer.valueOf(Integer.parseInt(aVar.b))).withValue("data3", aVar.c).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("email")) {
                            com.baidu.android.nebula.cmd.a.a aVar2 = (com.baidu.android.nebula.cmd.a.a) list.get(i2);
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/email_v2").withValue("data1", aVar2.d).withValue("data2", Integer.valueOf(Integer.parseInt(aVar2.b))).withValue("data3", aVar2.c).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("address")) {
                            com.baidu.android.nebula.cmd.a.a aVar3 = (com.baidu.android.nebula.cmd.a.a) list.get(i2);
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/postal-address_v2").withValue("data1", aVar3.d).withValue("data2", Integer.valueOf(Integer.parseInt(aVar3.b))).withValue("data3", aVar3.c).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("IM")) {
                            com.baidu.android.nebula.cmd.a.a aVar4 = (com.baidu.android.nebula.cmd.a.a) list.get(i2);
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/im").withValue("data5", Integer.valueOf(Integer.parseInt(aVar4.b))).withValue("data1", aVar4.d).withValue("data6", aVar4.c).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("website")) {
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/website").withValue("data1", ((com.baidu.android.nebula.cmd.a.a) list.get(i2)).d).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("organization")) {
                            com.baidu.android.nebula.cmd.a.a aVar5 = (com.baidu.android.nebula.cmd.a.a) list.get(i2);
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/organization").withValue("data1", aVar5.d).withValue("data2", Integer.valueOf(Integer.parseInt(aVar5.b))).withValue("data3", aVar5.c).build());
                        } else if (((com.baidu.android.nebula.cmd.a.a) list.get(i2)).a.equals("note")) {
                            arrayList2.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI).withValueBackReference("raw_contact_id", size).withValue("mimetype", "vnd.android.cursor.item/note").withValue("data1", ((com.baidu.android.nebula.cmd.a.a) list.get(i2)).d).build());
                        }
                    }
                }
            }
        }
        try {
            ArrayList arrayList3 = null;
            for (ContentProviderResult contentProviderResult : this.mContext.getContentResolver().applyBatch("com.android.contacts", arrayList2)) {
                if (contentProviderResult.uri != null) {
                    UriMatcher uriMatcher = new UriMatcher(-1);
                    uriMatcher.addURI("com.android.contacts", "raw_contacts/#", 1);
                    if (uriMatcher.match(contentProviderResult.uri) == 1) {
                        if (arrayList3 == null) {
                            arrayList3 = new ArrayList();
                        }
                        arrayList3.add(ContentUris.parseId(contentProviderResult.uri) + "");
                    }
                }
            }
            Long.valueOf(Calendar.getInstance().getTimeInMillis());
            return arrayList3;
        } catch (Exception e) {
            this.mErrcode = 5;
            return null;
        }
    }

    @Override // com.baidu.android.nebula.cmd.d
    public com.baidu.android.nebula.b.c execute(com.baidu.android.nebula.b.k kVar, Map map, Map map2, Map map3) {
        ArrayList applyBatchInsert;
        JSONObject jSONObject;
        a.a(System.currentTimeMillis());
        if (map2 == null || map2.size() < 1) {
            a.a(-1);
            return null;
        }
        String str = (String) map2.get("callback");
        a.d((String) map2.get("mcmdf"));
        if (str == null) {
            a.a(-1);
            return null;
        }
        this.mContext = com.baidu.android.nebula.d.b.a().c();
        if (this.mContext == null) {
            a.a(-1);
            return null;
        }
        if (com.baidu.android.moplus.util.a.o(this.mContext)) {
            if (!com.baidu.android.nebula.d.a.a(this.mContext).a((String) map.get("referer"))) {
                this.mErrcode = 4;
            }
            String str2 = (String) map2.get("postdata");
            if (TextUtils.isEmpty(str2)) {
                a.a(-1);
                return null;
            }
            if (this.mErrcode != 4) {
                this.mContacts = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        this.mContacts.add(com.baidu.android.nebula.cmd.a.b.a(jSONArray.getJSONObject(i)));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    this.mErrcode = -1;
                }
            }
            this.mErrcode = -1;
            if (this.mContacts != null && this.mContacts.size() > 0 && (applyBatchInsert = applyBatchInsert(this.mContacts)) != null && applyBatchInsert.size() > 0) {
                this.mErrcode = 0;
            }
        } else {
            this.mErrcode = 5;
            a.a(this.mErrcode);
        }
        try {
            new JSONObject().put("error", this.mErrcode);
        } catch (JSONException e2) {
        }
        com.baidu.android.nebula.b.c cVar = new com.baidu.android.nebula.b.c(str + " && " + str + "(" + jSONObject.toString() + ");");
        a.a(this.mErrcode);
        return cVar;
    }

    @Override // com.baidu.android.nebula.cmd.d
    public void writeToStatic() {
        k.a().a(this.mContext, a.toString());
    }
}
