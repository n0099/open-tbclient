package com.baidu.live.tieba.uiconfig;

import android.text.TextUtils;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveUIConfigInitialize {
    private Map<String, String> aVq = new HashMap();

    private LiveUIConfigInitialize() {
        init();
    }

    public void init() {
        String Fj = Fj();
        if (!TextUtils.isEmpty(Fj)) {
            eR(Fj);
        }
    }

    private void eR(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != null) {
                JSONObject optJSONObject = jSONObject.optJSONObject("gift_panel");
                if (optJSONObject != null) {
                    I(optJSONObject);
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("im_panel");
                if (optJSONObject2 != null) {
                    J(optJSONObject2);
                }
                this.aVq.put("charm_enter_view_bg", jSONObject.optString("charm_enter_view_bg"));
                this.aVq.put("ranklist_enter_view_bg", jSONObject.optString("ranklist_enter_view_bg"));
                this.aVq.put("audience_end_live_unfollow_btn_bg", jSONObject.optString("audience_end_live_unfollow_btn_bg"));
                this.aVq.put("audience_end_live_followed_btn_bg", jSONObject.optString("audience_end_live_followed_btn_bg"));
                this.aVq.put("host_end_live_view_charm_count_txt_color", jSONObject.optString("host_end_live_view_charm_count_txt_color"));
                this.aVq.put("start_live_btn_bg", jSONObject.optString("start_live_btn_bg"));
                this.aVq.put("ranklist_bottom_btn_bg", jSONObject.optString("ranklist_bottom_btn_bg"));
                JSONObject optJSONObject3 = jSONObject.optJSONObject("person_card");
                if (optJSONObject3 != null) {
                    H(optJSONObject3);
                }
                JSONObject optJSONObject4 = jSONObject.optJSONObject("tab_indicator");
                if (optJSONObject4 != null) {
                    G(optJSONObject4);
                }
                JSONObject optJSONObject5 = jSONObject.optJSONObject("attention_btn");
                if (optJSONObject5 != null) {
                    F(optJSONObject5);
                }
                this.aVq.put("host_header_attention_btn_bg", jSONObject.optString("host_header_attention_btn_bg"));
                JSONObject optJSONObject6 = jSONObject.optJSONObject("top_tip_panel");
                if (optJSONObject6 != null) {
                    E(optJSONObject6);
                }
                JSONObject optJSONObject7 = jSONObject.optJSONObject("bottom_dialog");
                if (optJSONObject7 != null) {
                    D(optJSONObject7);
                }
                JSONObject optJSONObject8 = jSONObject.optJSONObject("function_btn_bg_res");
                if (optJSONObject8 != null) {
                    C(optJSONObject8);
                }
                this.aVq.put("user_sex_male_icon", jSONObject.optString("user_sex_male_icon"));
                this.aVq.put("user_sex_female_icon", jSONObject.optString("user_sex_female_icon"));
                this.aVq.put("default_user_header_icon", jSONObject.optString("default_user_header_icon"));
                this.aVq.put("no_list_tip_img", jSONObject.optString("no_list_tip_img"));
                this.aVq.put("no_data_tip_img", jSONObject.optString("no_data_tip_img"));
                this.aVq.put("no_network_tip_img", jSONObject.optString("no_network_tip_img"));
                this.aVq.put("data_err_tip_img", jSONObject.optString("data_err_tip_img"));
                this.aVq.put("no_fans_tip_img", jSONObject.optString("no_fans_tip_img"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void C(JSONObject jSONObject) {
        this.aVq.put("light_switch_normal", jSONObject.optString("light_switch_normal"));
        this.aVq.put("light_switch_pressed", jSONObject.optString("light_switch_pressed"));
        this.aVq.put("exchange_camera_normal", jSONObject.optString("exchange_camera_normal"));
        this.aVq.put("exchange_camera_pressed", jSONObject.optString("exchange_camera_pressed"));
        this.aVq.put("beauty_normal", jSONObject.optString("beauty_normal"));
        this.aVq.put("beauty_pressed", jSONObject.optString("beauty_pressed"));
        this.aVq.put("prepare_close_normal", jSONObject.optString("prepare_close_normal"));
        this.aVq.put("prepare_close_pressed", jSONObject.optString("prepare_close_pressed"));
        this.aVq.put("pk_normal", jSONObject.optString("pk_normal"));
        this.aVq.put("pk_pressed", jSONObject.optString("pk_pressed"));
        this.aVq.put("more_normal", jSONObject.optString("more_normal"));
        this.aVq.put("more_pressed", jSONObject.optString("more_pressed"));
        this.aVq.put("send_msg_normal", jSONObject.optString("send_msg_normal"));
        this.aVq.put("send_msg_pressed", jSONObject.optString("send_msg_pressed"));
        this.aVq.put("share_normal", jSONObject.optString("share_normal"));
        this.aVq.put("share_pressed", jSONObject.optString("share_pressed"));
        this.aVq.put("send_gift_normal", jSONObject.optString("send_gift_normal"));
        this.aVq.put("send_gift_pressed", jSONObject.optString("send_gift_pressed"));
        this.aVq.put("zan_normal", jSONObject.optString("zan_normal"));
        this.aVq.put("zan_pressed", jSONObject.optString("zan_pressed"));
    }

    private void D(JSONObject jSONObject) {
        this.aVq.put("bottom_tip_panel_bg", jSONObject.optString("bottom_tip_panel_bg"));
        this.aVq.put("bottom_tip_panel_item_bg", jSONObject.optString("bottom_tip_panel_item_bg"));
        this.aVq.put("bottom_tip_panel_item_txt_color", jSONObject.optString("bottom_tip_panel_item_txt_color"));
        this.aVq.put("bottom_tip_panel_title_item_bg", jSONObject.optString("bottom_tip_panel_title_item_bg"));
        this.aVq.put("bottom_tip_panel_title_item_txt_color", jSONObject.optString("bottom_tip_panel_title_item_txt_color"));
    }

    private void E(JSONObject jSONObject) {
        this.aVq.put("top_tip_bg", jSONObject.optString("top_tip_bg"));
        this.aVq.put("top_tip_txt_color", jSONObject.optString("top_tip_txt_color"));
        this.aVq.put("top_tip_btn_bg", jSONObject.optString("top_tip_btn_bg"));
        this.aVq.put("top_tip_btn_txt_color", jSONObject.optString("top_tip_btn_txt_color"));
    }

    private void F(JSONObject jSONObject) {
        this.aVq.put("attention_btn_unfollow_bg", jSONObject.optString("attention_btn_unfollow_bg"));
        this.aVq.put("attention_btn_unfollow_text_color", jSONObject.optString("attention_btn_unfollow_text_color"));
        this.aVq.put("attention_btn_followed_bg", jSONObject.optString("attention_btn_followed_bg"));
        this.aVq.put("attention_btn_followed_text_color", jSONObject.optString("attention_btn_followed_text_color"));
    }

    private void G(JSONObject jSONObject) {
        this.aVq.put("tab_indicator_start_color", jSONObject.optString("tab_indicator_start_color"));
        this.aVq.put("tab_indicator_end_color", jSONObject.optString("tab_indicator_end_color"));
    }

    private void H(JSONObject jSONObject) {
        this.aVq.put("person_card_follow_txt_unfollow_color", jSONObject.optString("person_card_follow_txt_unfollow_color"));
        this.aVq.put("person_card_follow_txt_followed_color", jSONObject.optString("person_card_follow_txt_followed_color"));
    }

    private void I(JSONObject jSONObject) {
        this.aVq.put("gift_send_btn_bg", jSONObject.optString("gift_send_btn_bg"));
        this.aVq.put("gift_label_common_bg", jSONObject.optString("gift_label_common_bg"));
        this.aVq.put("gift_label_fans_bg", jSONObject.optString("gift_label_fans_bg"));
        this.aVq.put("gift_num_btn_bg", jSONObject.optString("gift_num_btn_bg"));
        this.aVq.put("gift_num_edit_cursor_color", jSONObject.optString("gift_num_edit_cursor_color"));
    }

    private void J(JSONObject jSONObject) {
        this.aVq.put("im_send_btn_bg", jSONObject.optString("im_send_btn_bg"));
        this.aVq.put("im_edit_hint_txt", jSONObject.optString("im_edit_hint_txt"));
        this.aVq.put("im_edit_hint_txt_color", jSONObject.optString("im_edit_hint_txt_color"));
        this.aVq.put("im_edit_cursor_color", jSONObject.optString("im_edit_cursor_color"));
        this.aVq.put("im_msg_common_bg", jSONObject.optString("im_msg_common_bg"));
        this.aVq.put("im_msg_fans_bg", jSONObject.optString("im_msg_fans_bg"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=4] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String Fj() {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        String str = null;
        try {
            bufferedInputStream = new BufferedInputStream(TbadkCoreApplication.getInst().getAssets().open("live_ui_config.json"));
            try {
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
                    str = sb.toString();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
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
            } catch (Throwable th2) {
                th = th2;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            bufferedInputStream = null;
            th = th3;
            if (bufferedInputStream != null) {
            }
            throw th;
        }
        return str;
    }
}
