package com.baidu.live.alablmsdk.b;

import android.text.TextUtils;
import com.baidu.android.imrtc.utils.IStatusListener;
import com.baidu.live.alablmsdk.a.c;
import com.baidu.live.alablmsdk.a.e;
import com.baidu.live.alablmsdk.module.UserPermission;
import com.baidu.live.alablmsdk.module.state.LegacyRoomStatus;
/* loaded from: classes4.dex */
public class a {
    private com.baidu.live.alablmsdk.e.b aAE;
    com.baidu.live.alablmsdk.module.a.a aAF;

    public a(com.baidu.live.alablmsdk.e.b bVar) {
        this.aAE = bVar;
    }

    public void a(String str, UserPermission userPermission) {
        this.aAF = new com.baidu.live.alablmsdk.module.a.a(str, userPermission.getPermission(), LegacyRoomStatus.LOGIC_ACTIVE.getStatus());
        String jsonString = this.aAF.toJsonString();
        c.d(" putCurrentRoomInfo roomInfo=" + jsonString);
        c.fJ(" putCurrentRoomInfo roomInfo " + jsonString);
        e.Bj().putString("legacy_room_info_kye", jsonString);
    }

    public void a(LegacyRoomStatus legacyRoomStatus) {
        if (this.aAF != null) {
            this.aAF.aBm = legacyRoomStatus.getStatus();
            String jsonString = this.aAF.toJsonString();
            c.d(" updateCurrentRoomStatus  roomInfo=" + jsonString);
            c.fJ(" updateCurrentRoomStatus roomInfo " + jsonString);
            e.Bj().putString("legacy_room_info_kye", jsonString);
        }
    }

    public void Bq() {
        e.Bj().putString("legacy_room_info_kye", "");
    }

    public void Br() {
        c.d(" handleLongConnectionLegacyRoom ");
        c.fJ(" handleLongConnectionLegacyRoom ");
        if (this.aAF != null && !TextUtils.isEmpty(this.aAF.roomId) && this.aAF.aBm == LegacyRoomStatus.LOGIC_END_FAIL.getStatus() && this.aAE != null) {
            final String str = this.aAF.roomId;
            if (this.aAF.permission == UserPermission.OWNER.getPermission()) {
                c.d(" handleLongConnectionLegacyRoom  closeRoom");
                c.fJ(" handleLongConnectionLegacyRoom  closeRoom");
                this.aAE.a(this.aAF.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.1
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str2) {
                        c.d(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        c.fJ(" handleLongConnectionLegacyRoom closeRoom onResult code=" + i);
                        if (i == 0) {
                            c.d(" handleLongConnectionLegacyRoom closeRoom  success");
                            c.fJ(" handleLongConnectionLegacyRoom closeRoom  success");
                            if (!TextUtils.isEmpty(str) && str.equals(a.this.aAF.roomId)) {
                                c.d(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                c.fJ(" handleLongConnectionLegacyRoom  clearLegacyRoomInfo");
                                a.this.Bq();
                            }
                        }
                    }
                });
                return;
            }
            c.d(" handleLongConnectionLegacyRoom  hangout");
            c.fJ(" handleLongConnectionLegacyRoom  hangout");
            this.aAE.hangout(this.aAF.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.2
                @Override // com.baidu.android.imrtc.utils.IStatusListener
                public void onResult(int i, String str2) {
                    if (i == 0) {
                        c.d(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        c.fJ(" handleLongConnectionLegacyRoom hangout onResult code=" + i);
                        if (!TextUtils.isEmpty(str) && str.equals(a.this.aAF.roomId)) {
                            a.this.Bq();
                            return;
                        }
                        return;
                    }
                    c.d(" handleLongConnectionLegacyRoom hangout fail , code=" + i);
                    c.fJ(" handleLongConnectionLegacyRoom hangout fail code " + i);
                }
            });
        }
    }

    public void Bs() {
        String string = e.Bj().getString("legacy_room_info_kye");
        c.d(" closeLegacyRoom legacyRoomInfo=" + string);
        c.fJ(" closeLegacyRoom legacyRoomInfo " + string);
        this.aAF = com.baidu.live.alablmsdk.module.a.a.fM(string);
        if (this.aAF != null && !TextUtils.isEmpty(this.aAF.roomId)) {
            if ((this.aAF.aBm == LegacyRoomStatus.LOGIC_ACTIVE.getStatus() || this.aAF.aBm == LegacyRoomStatus.LOGIC_END_FAIL.getStatus()) && this.aAE != null) {
                c.d(" closeLegacyRoom  closeRoom");
                c.fJ(" closeLegacyRoom  closeRoom");
                if (this.aAF.permission == UserPermission.OWNER.getPermission()) {
                    this.aAE.a(this.aAF.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.3
                        @Override // com.baidu.android.imrtc.utils.IStatusListener
                        public void onResult(int i, String str) {
                            if (i == 0) {
                                c.d(" handleInitLegacyRoom closeRoom  success , clearLegacyRoomInfo");
                                c.fJ(" handleInitLegacyRoom closeRoom success clearLegacyRoomInfo");
                                a.this.Bq();
                            }
                        }
                    });
                    return;
                }
                c.d(" handleInitLegacyRoom  hangout");
                c.fJ(" handleInitLegacyRoom  hangout");
                this.aAE.hangout(this.aAF.roomId, new IStatusListener() { // from class: com.baidu.live.alablmsdk.b.a.4
                    @Override // com.baidu.android.imrtc.utils.IStatusListener
                    public void onResult(int i, String str) {
                        if (i == 0) {
                            c.d(" handleInitLegacyRoom hangout success , clearLegacyRoomInfo");
                            c.fJ(" handleInitLegacyRoom hangout success clearLegacyRoomInfo");
                            a.this.Bq();
                        }
                    }
                });
            }
        }
    }
}
