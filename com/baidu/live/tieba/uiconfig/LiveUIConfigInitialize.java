package com.baidu.live.tieba.uiconfig;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class LiveUIConfigInitialize {
    private Map<String, String> bLi = new HashMap();

    private LiveUIConfigInitialize() {
        init();
    }

    public void init() {
        String Wp = Wp();
        if (!TextUtils.isEmpty(Wp)) {
            iH(Wp);
        }
    }

    private void iH(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("gift_panel");
                if (optJSONObject != null) {
                    ag(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_panel");
                if (optJSONObject2 != null) {
                    ah(optJSONObject2);
                }
                this.bLi.put("charm_enter_view_bg", jSONObject.optString("charm_enter_view_bg"));
                this.bLi.put("ranklist_enter_view_bg", jSONObject.optString("ranklist_enter_view_bg"));
                this.bLi.put("audience_end_live_unfollow_btn_bg", jSONObject.optString("audience_end_live_unfollow_btn_bg"));
                this.bLi.put("audience_end_live_followed_btn_bg", jSONObject.optString("audience_end_live_followed_btn_bg"));
                this.bLi.put("host_end_live_view_charm_count_txt_color", jSONObject.optString("host_end_live_view_charm_count_txt_color"));
                this.bLi.put("start_live_btn_bg", jSONObject.optString("start_live_btn_bg"));
                this.bLi.put("ranklist_bottom_btn_bg", jSONObject.optString("ranklist_bottom_btn_bg"));
                JSONObject optJSONObject3 = jSONObject.optJSONObject("person_card");
                if (optJSONObject3 != null) {
                    af(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("tab_indicator");
                if (optJSONObject4 != null) {
                    ae(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("attention_btn");
                if (optJSONObject5 != null) {
                    ad(optJSONObject5);
                }
                this.bLi.put("host_header_attention_btn_bg", jSONObject.optString("host_header_attention_btn_bg"));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("top_tip_panel");
                if (optJSONObject6 != null) {
                    ac(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("bottom_dialog");
                if (optJSONObject7 != null) {
                    ab(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("function_btn_bg_res");
                if (optJSONObject8 != null) {
                    aa(optJSONObject8);
                }
                this.bLi.put("user_sex_male_icon", jSONObject.optString("user_sex_male_icon"));
                this.bLi.put("user_sex_female_icon", jSONObject.optString("user_sex_female_icon"));
                this.bLi.put("default_user_header_icon", jSONObject.optString("default_user_header_icon"));
                this.bLi.put("no_list_tip_img", jSONObject.optString("no_list_tip_img"));
                this.bLi.put("no_data_tip_img", jSONObject.optString("no_data_tip_img"));
                this.bLi.put("no_network_tip_img", jSONObject.optString("no_network_tip_img"));
                this.bLi.put("data_err_tip_img", jSONObject.optString("data_err_tip_img"));
                this.bLi.put("no_fans_tip_img", jSONObject.optString("no_fans_tip_img"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void aa(JSONObject jSONObject) {
        this.bLi.put("light_switch_normal", jSONObject.optString("light_switch_normal"));
        this.bLi.put("light_switch_pressed", jSONObject.optString("light_switch_pressed"));
        this.bLi.put("exchange_camera_normal", jSONObject.optString("exchange_camera_normal"));
        this.bLi.put("exchange_camera_pressed", jSONObject.optString("exchange_camera_pressed"));
        this.bLi.put("beauty_normal", jSONObject.optString("beauty_normal"));
        this.bLi.put("beauty_pressed", jSONObject.optString("beauty_pressed"));
        this.bLi.put("prepare_close_normal", jSONObject.optString("prepare_close_normal"));
        this.bLi.put("prepare_close_pressed", jSONObject.optString("prepare_close_pressed"));
        this.bLi.put("pk_normal", jSONObject.optString("pk_normal"));
        this.bLi.put("pk_pressed", jSONObject.optString("pk_pressed"));
        this.bLi.put("more_normal", jSONObject.optString("more_normal"));
        this.bLi.put("more_pressed", jSONObject.optString("more_pressed"));
        this.bLi.put("send_msg_normal", jSONObject.optString("send_msg_normal"));
        this.bLi.put("send_msg_pressed", jSONObject.optString("send_msg_pressed"));
        this.bLi.put("share_normal", jSONObject.optString("share_normal"));
        this.bLi.put("share_pressed", jSONObject.optString("share_pressed"));
        this.bLi.put("send_gift_normal", jSONObject.optString("send_gift_normal"));
        this.bLi.put("send_gift_pressed", jSONObject.optString("send_gift_pressed"));
        this.bLi.put("zan_normal", jSONObject.optString("zan_normal"));
        this.bLi.put("zan_pressed", jSONObject.optString("zan_pressed"));
    }

    private void ab(JSONObject jSONObject) {
        this.bLi.put("bottom_tip_panel_bg", jSONObject.optString("bottom_tip_panel_bg"));
        this.bLi.put("bottom_tip_panel_item_bg", jSONObject.optString("bottom_tip_panel_item_bg"));
        this.bLi.put("bottom_tip_panel_item_txt_color", jSONObject.optString("bottom_tip_panel_item_txt_color"));
        this.bLi.put("bottom_tip_panel_title_item_bg", jSONObject.optString("bottom_tip_panel_title_item_bg"));
        this.bLi.put("bottom_tip_panel_title_item_txt_color", jSONObject.optString("bottom_tip_panel_title_item_txt_color"));
    }

    private void ac(JSONObject jSONObject) {
        this.bLi.put("top_tip_bg", jSONObject.optString("top_tip_bg"));
        this.bLi.put("top_tip_txt_color", jSONObject.optString("top_tip_txt_color"));
        this.bLi.put("top_tip_btn_bg", jSONObject.optString("top_tip_btn_bg"));
        this.bLi.put("top_tip_btn_txt_color", jSONObject.optString("top_tip_btn_txt_color"));
    }

    private void ad(JSONObject jSONObject) {
        this.bLi.put("attention_btn_unfollow_bg", jSONObject.optString("attention_btn_unfollow_bg"));
        this.bLi.put("attention_btn_unfollow_text_color", jSONObject.optString("attention_btn_unfollow_text_color"));
        this.bLi.put("attention_btn_followed_bg", jSONObject.optString("attention_btn_followed_bg"));
        this.bLi.put("attention_btn_followed_text_color", jSONObject.optString("attention_btn_followed_text_color"));
    }

    private void ae(JSONObject jSONObject) {
        this.bLi.put("tab_indicator_start_color", jSONObject.optString("tab_indicator_start_color"));
        this.bLi.put("tab_indicator_end_color", jSONObject.optString("tab_indicator_end_color"));
    }

    private void af(JSONObject jSONObject) {
        this.bLi.put("person_card_follow_txt_unfollow_color", jSONObject.optString("person_card_follow_txt_unfollow_color"));
        this.bLi.put("person_card_follow_txt_followed_color", jSONObject.optString("person_card_follow_txt_followed_color"));
    }

    private void ag(JSONObject jSONObject) {
        this.bLi.put("gift_send_btn_bg", jSONObject.optString("gift_send_btn_bg"));
        this.bLi.put("gift_label_common_bg", jSONObject.optString("gift_label_common_bg"));
        this.bLi.put("gift_label_fans_bg", jSONObject.optString("gift_label_fans_bg"));
        this.bLi.put("gift_num_btn_bg", jSONObject.optString("gift_num_btn_bg"));
        this.bLi.put("gift_num_edit_cursor_color", jSONObject.optString("gift_num_edit_cursor_color"));
    }

    private void ah(JSONObject jSONObject) {
        this.bLi.put("im_send_btn_bg", jSONObject.optString("im_send_btn_bg"));
        this.bLi.put("im_edit_hint_txt", jSONObject.optString("im_edit_hint_txt"));
        this.bLi.put("im_edit_hint_txt_color", jSONObject.optString("im_edit_hint_txt_color"));
        this.bLi.put("im_edit_cursor_color", jSONObject.optString("im_edit_cursor_color"));
        this.bLi.put("im_msg_common_bg", jSONObject.optString("im_msg_common_bg"));
        this.bLi.put("im_msg_fans_bg", jSONObject.optString("im_msg_fans_bg"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String Wp() {
        BufferedInputStream bufferedInputStream;
        String str = 0;
        str = 0;
        str = 0;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(TbadkCoreApplication.getInst().getAssets().open("live_ui_config.json"));
                try {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    String sb2 = sb.toString();
                    str = sb2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            str = sb2;
                        } catch (IOException e) {
                            e.printStackTrace();
                            str = sb2;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return str;
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        str.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            throw th;
        }
        return str;
    }
}
